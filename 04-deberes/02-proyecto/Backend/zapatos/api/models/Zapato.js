/**
 * Zapato.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    marca: {
      type: 'string',
      required: true,
      minLength: 4,
      maxLength: 15,
    },
    color: {
      type: 'string',
      required: true,
      minLength: 6,
      maxLength: 15,
    },
    talla: {
      type: 'number',
      required: true,
      min: 25,
      max: 42,
    },
    tipo: {
      type: 'string',
      required: true,
      unique: true,
      maxLength: 6,
    },
    cantidad: {
      type: 'number',
      required: true,
      min: 0,
    },
    precio: {
      type: 'number',
      required: true,
      min: 0,
    },
    compraDeZapato: {     // Nombre atributo de la relación
      collection: 'compra', // Nombre del modelo a relacionar
      via: 'codigoZap'        // Nombre del campo a hacer la relacion
    },
  },
}