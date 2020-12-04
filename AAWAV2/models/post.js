const mongoose = require('mongoose')

const postsSchema = new mongoose.Schema({
    id : {
        type: String,
        required: true
    },
    userId: {
        type: String,
        required: true
    },
    conteudo: {
        type: String,
        required: true
    },
    foto: {
        type: String,
        required: true
    },
    status: {
        type: String,
        required: true
    },
    dataDeCriacao: {
        type: Date,
        required: true,
        default: Date.now
    },
    dataDeModificacao: {
        type: Date,
        required: true,
        default: Date.now
    }
})


// configurando o esquema no banco
module.exports = mongoose.model('post', postsSchema)