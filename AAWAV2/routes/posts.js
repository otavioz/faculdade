const express = require('express')

const router = express.Router()

const post = require('../models/post')

// GET all
router.get('/', async (req, res) => {
    try {
        const posts = await post.find()
        return res.send(posts)
    }catch (err) {
        console.log(err.message)
        res.status(500).json({message: err.message})
    }
})

// GET by ID
router.get('/:id', getpost, async (req, res) => {

    res.json(res.post)
})

// GET by userID
router.get('/:userId', getpost, async (req, res) => {

    res.json(res.post)
})

// post create
router.post('/', async (req, res) => {

    const { v1: uuidv1 } = require('uuid');

    const post = new post({
        userId: uuidv1(),
        conteudo: req.body.conteudo,
        foto: req.body.foto,
        status: 'criado',
        dataDeCriacao: Date.now().format('MM/DD/YYYY')
    })

    try {
        const created = await post.save()

        res.status(201).json(created)
    }catch (err) {
        res.status(400).json({message: err.message})
    }
})

// PATCH update
router.patch('/:id', getpost, async (req, res) => {
    if (req.body.conteudo != null) {
        res.post.conteudo = req.body.conteudo
    }

    if (req.body.foto != null) {
        res.post.foto = req.body.foto
    }
    res.post.dataDeModificacao = Date.now().format('MM/DD/YYYY');

    try {
        const updated = await res.post.save()

        res.json(updated)
    }catch (err) {
        res.status(400).json({message: err.message})
    }
})

// PATCH update
router.patch('publicar/:id', getpost, async (req, res) => {

    res.post.status = 'publicado'
    res.post.dataDeModificacao = Date.now().format('MM/DD/YYYY')
    
    try {
        const updated = await res.post.save()

        res.json(updated)
    }catch (err) {
        res.status(400).json({message: err.message})
    }
})


// DELETE remove
router.delete('/:id', getpost, async (req, res) => {

    try {
        await res.post.remove()

        res.json({message: 'Deleted Successfully'})
    } catch (err) {
        res.status(500).json({message: err.message})
    }
})

// middleware
async function getpost(req, res, next) {
    try {
        post = await post.findById(req.params.id)

        if (post == null) {
            return res.status(404).json({message: 'post not found'})
        }
    }catch (err) {
        res.status(500).json({message: err.message})
    }

    res.post = post

    next()
}

// export
module.exports = router