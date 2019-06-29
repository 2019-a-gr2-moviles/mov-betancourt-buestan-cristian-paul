/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombreAtributo: {
      type: 'string'
    },
    nombre: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 60,
    },
    cedula: {
      type: 'string',
      required: true,
      unique: true,
      minLength: 10,
      maxLength: 25,
    },
    username: {
      type: 'string',
      required: true,
      unique: true
    },
    fechaNacimiento: {
      type: 'string'
    },
    sueldo: {
      type: 'number',
      min: 100.00,
      max: 5000,
      defaultsTo: 100.00
    },
    estaCasado: {
      
    },
    latitudCasa: {
      type: 'string'
    },
    longitudCasa: {
      type: 'string'
    },
    tipoUsuario: {
      type: 'string',
      enum: ['normal', 'pendiente', 'premium']
    },
    correo: {
      type: 'string',
      isEmail: true
    },

    // CONFIGURACIÓN DEL PADRE
    serviciosDeUsuario: {     // Nombre atributo de la relación
      collection: 'servicio', // Nombre del modelo a relacionar
      via: 'idUsuario'        // Nombre del campo a hacer la relacion
    },
    
    idEmpresa: {
      model: 'empresa'
    }
  },

};
// http://localhost:1337/usuario
// Estandar RESTFUL+

// CREAR
// http://localhost:1337/usuario
// MÉTODO HTTP: POST
// BODY PARAMS: USUARIO


// ACTUALIZAR
// http://localhost:1337/usuario/:id
// http://localhost:1337/usuario/2
// MÉTODO HTTP: PUT
// BODY PARAMS: USUARIO

// BORRAR
// http://localhost:1337/usuario/:id
// http://localhost:1337/usuario/2
// MÉTODO HTTP: DELETE

// BUSCAR POR ID
// http://localhost:1337/usuario/:id
// http://localhost:1337/usuario/2
// MÉTODO HTTP: GET

// OBTENER TODOS (Enviar parámetros de busqueda)
// http://localhost:1337/usuario
// MÉTODO HTTP: GET


// EJEMPLOS
// 1) Buscar usuario con nombre Cristian
// http://localhost:1337/usuario?nombre=Cristian

// 2) Buscar usuario con nombre Cristian y cedula 1
// http://localhost:1337/usuario?nombre=Cristian&cedula=1718029658

// 3) Traer los primeros 5
// http://localhost:1337/usuario?limit=5

// 4) Traer los primeros 5 despues de los primeros 10
// http://localhost:1337/usuario?limit=5&skip=10

// 5) Traer los registros ordenados por nombre
// http://localhost:1337/usuario?sort=nombre DESC
// http://localhost:1337/usuario?sort=nombre ASC

// 6) Traer los registros que contengan en el nombre la letra A
// http://localhost:1337/usuario?where={"nombre":{"contains":"a"}}
// http://localhost:1337/usuario?where={"sueldo":{"<=":"a"}}