/**
 * Medicamento.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    gramosAIngerir: {
      required: true,
      type: 'number',
      min: 0
    },
    nombre: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 20,
    },
    composicion: {
      type: 'string',
      required: true,
      minLength: 0,
      maxLength: 20,
    },
    usadoPara: {
      type: 'string',
      required: true,
      minLength: 0,
      maxLength: 20,
    },
    fechaCaducidad: {
      required: true,
      type: 'string'
    },
    numeroPastillas: {
      required: true,
      type: 'number',
      min: 0
    },
    longitud: {
      required: true,
      type: 'string'
    },
    latitud: {
      required: true,
      type: 'string'
    },
    idPaciente: {         // Nombre del fk para la relación
      model: 'paciente',   // Nombre del modelo a relacionar (padre) 
      required: true   // OPCIONAL-> Simpre se ingrese el fk
    }
  },

};

