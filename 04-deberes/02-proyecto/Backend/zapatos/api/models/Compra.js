/**
 * Compra.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    fecha: {
      type: 'string',
      required:true
    },
    cantidad: {
      type: 'number',
      min: 0,
      required:true
    },
    cantidad: {
      type: 'number',
      min: 0,
      required:true
    },
    validez:{
      type: 'boolean',
      defaultsTo: true
    },
    codigoZap: {         // Nombre del fk para la relación
      model: 'zapato',   // Nombre del modelo a relacionar (padre) 
      required: true   // OPCIONAL-> Simpre se ingrese el fk
    },
    codigoCli: {         // Nombre del fk para la relación
      model: 'cliente',   // Nombre del modelo a relacionar (padre) 
      required: true   // OPCIONAL-> Simpre se ingrese el fk
    },
   },

};

