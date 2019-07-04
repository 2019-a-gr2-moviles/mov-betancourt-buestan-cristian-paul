/**
 * Cliente.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombre: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 15,
    },
    cedula: {
      type: 'string',
      required: true,
      unique: true,
      minLength: 10,
      maxLength: 25,
    },
    apellido: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 15,
    },
    compraDeCliente: {     // Nombre atributo de la relación
      collection: 'compra', // Nombre del modelo a relacionar
      via: 'codigoCli'        // Nombre del campo a hacer la relacion
    },
  },
};

