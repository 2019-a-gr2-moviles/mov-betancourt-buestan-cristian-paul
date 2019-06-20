/**
 * Usuario.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombreAtributo:{
      type: 'string'
    },
  nombre:{
      type: 'string',
      required: true
    },
    cedula:{
      type: 'string',
      required: true,
      unique: true
    },
     username:{
      type: 'string',
      required: true,
      unique: true
    },
    fechaNacimiento: {
      type: 'string'
    },
    sueldo:{
      type: 'number',
      defaultsTo:100.00,
      min:100.00,
      max:5000
    },
estaCasado:{
      type:'boolean',
      defaultsTo: false
    },
    latitudCasa:{
      type: 'string'
    },
    longitudCasa:{
      type: 'string'
    },
    tipoUsuario:{
      type: 'string',
      required: true,
      unique: true
    },



  },

};

