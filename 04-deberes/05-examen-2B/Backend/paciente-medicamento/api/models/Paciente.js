/**
 * Paciente.js
 *
 * @description :: A model definition represents a database table/collection.
 * @docs        :: https://sailsjs.com/docs/concepts/models-and-orm/models
 */

module.exports = {

  attributes: {
    nombres: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 30,
    },
    apellidos: {
      type: 'string',
      required: true,
      minLength: 3,
      maxLength: 30,
    },
    fechaNacimiento: {
      required: true,
      type: 'string'
    },
    hijos: {
      required: true,
      type: 'number',
      min: 0
    },
    tieneSeguro:{      
      required: true,
      type: 'boolean'
    },
    medicamentoDePaciente: {     // Nombre atributo de la relación
      collection: 'medicamento', // Nombre del modelo a relacionar
      via: 'idPaciente'        // Nombre del campo a hacer la relacion
    },
  },
};

