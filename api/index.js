const express = require('express')
const mysql = require('mysql')
const bodyParser = require('body-parser')

const app = express()

app.use(bodyParser.json())

const PUERTO = 3000

const conexion = mysql.createConnection(
    {
        host:'localhost',
        database:'pruebas',
        user: 'root',
        password:''
    }
)

app.listen(PUERTO,()=>{
    console.log("servidor corriendo en el puerto 3000")
})

conexion.connect(error => {
    if(error) throw error
    console.log('Conexion exitosa a la base de datos')
})

app.get('/', (req,res) =>{
    res.send('API')
})

app.get('/usuarios', (req,res) =>{
    const query = `SELECT * FROM usuarios`

    conexion.query(query,(error,resultado) => {
        if(error) return console.error(error.message)

        const obj = {}
        if(resultado.length > 0){
            obj.listaUsuarios = resultado
            res.json(obj)
        }else{
            res.json('No hay registros')
        }
    })
    
})

app.get('/usuario/:id', (req,res) =>{
    const { id } = req.params

    const query = `SELECT * FROM usuarios WHERE id=${id}`
    
    conexion.query(query,(error,resultado) => {
        if(error) return console.error(error.message)

        const obj = {}
        if(resultado.length > 0){
            obj.listaUsuarios = resultado
            res.json(obj)
        }else{
            res.json('No hay registros')
        }
    })
    
})

app.post('/usuario/add', (req,res) =>{
    const usuario = {
        nombre: req.body.nombre,
        email: req.body.email
    }

    const query = `INSERT INTO usuarios SET ?`
    
    conexion.query(query, usuario, (error) => {
        if(error) return console.error(error.message)

        res.json('Se inserto correctamente el usuario')
        
    })
    
})

app.put('/usuario/update/:id', (req,res) =>{

    const { id } = req.params
    const {nombre, email} = req.body

    const query = `UPDATE usuarios SET nombre ='${nombre}', email ='${email} WHERE id=${id}'`
    
    conexion.query(query,(error) => {
        if(error) return console.error(error.message)

        res.json('Se actualizo correctamente el usuario')
        
    })
    
})

app.delete('/usuario/delete/:id', (req,res) =>{

    const { id } = req.params
    const {nombre, email} = req.body

    const query = `DELETE FROM usuarios WHERE id=${id}'`
    
    conexion.query(query,(error) => {
        if(error) return console.error(error.message)

        res.json('Se elimino correctamente el usuario')
        
    })
    
})