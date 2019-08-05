'using strict'

const express  = require('express');
const http = require('http');
const bodyparser = require('body-parser');
const mysql = require('mysql');
const porta = 8000;

const app = express();
app.use(bodyparser.urlencoded({ extended : true}));
app.use(bodyparser.json());

//acrescentando informacoes de cabecalho para suportar o CORS
app.use(function(req, res, next) {
    res.header("Access-Control-Allow-Origin", "*");
    res.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
    res.header("Access-Control-Allow-Methods", "GET, POST, HEAD, OPTIONS, PATCH, DELETE");
    next();
  });
const roteador = express.Router();
roteador.get('/', (req,res) => res.json({
    message : 'FUNCIONOU!'
    })
);
roteador.get('/Compras', (req,res) => {
    execSQLQuery('SELECT * FROM ingresso',res);
})

roteador.get('/cliente', (req,res) =>{
    execSQLQuery('SELECT * FROM pessoa',res);
})

roteador.get('/consulta/preco', (req,res) =>{
    execSQLQuery('SELECT preco FROM ingresso',res);
})

roteador.get('/consulta/setor', (req,res) =>{
    execSQLQuery('SELECT id_arquibancada FROM arquibancada');
})

roteador.get('/consulta/data',(req,res) =>{
    execSQLQuery('SELECT data FROM circuito',res);
})

roteador.get('/consulta/',(req,res) =>{
    execSQLQuery('SELECT * from pessoa',res);
})

roteador.get('/', (req,res) => {
    execSQLQuery('SELECT * from pessoa',res);
})

// roteador.post('/insercao', (req,res) => {
//     const nome = req.body.nome.substring(0,200);
//     const id = req.body.id.substring(0,11);
//     execSQLQuery(`INSERT INTO Insercao VALUES('${id}','${nome}')`,res)
// });







app.use('/', roteador);
app.listen(porta);
console.log("Servidor rodando no hostlocal, porta: "+porta);

//consultar os clientes do bd
function execSQLQuery(sqlQry, res){
    const connection = mysql.createConnection({
        host : '127.0.0.1',
        port : '3306',
        user : 'root',
        password : '',
        database : 'formula1'
    });

    connection.query(sqlQry, function(error, results, fields){
        if(error)
        {          
          res.json(error);
        }
          else
          res.json(results);
        connection.end();
        console.log('executou!');
    });
  }
  roteador.get('/circuito/:id?',(req,res) =>{
      let filtro ='';
      if(req.params.id)
        filtro = ' where id_circuito ='+parseInt(req.params.id);
        execSQLQuery('Select * from circuito'+ filtro,res);
  })

roteador.get('/pessoas/:id?', (req,res) =>{
    let filtro = '';
    if(req.params.id)
        filtro = ' where cpf = '+parseInt(req.params.id); 
    execSQLQuery('Select * from pessoa '+ filtro,res);
})

// minha parte da pagina colocar no server do JackDaniels
// criando um roteador para listar os itens da pagina index.html
roteador.get('/proximasCorridas', (req,res) =>{
    execSQLQuery('select * from circuito',res)
})