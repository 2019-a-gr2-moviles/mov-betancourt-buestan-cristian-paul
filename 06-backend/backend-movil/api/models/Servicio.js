/**
 * Servicio.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre: {
      type: 'string'
    },
    
    idUsuario: {         // Nombre del fk para la relación
      model: 'usuario'   // Nombre del modelo a relacionar (padre) 
      // required: true   // OPCIONAL-> Simpre se ingrese el fk
    }
  },

};

