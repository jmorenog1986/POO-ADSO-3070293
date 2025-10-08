 $(document).ready(function() {
            // Inicializar datepicker
            $('#fechaNacimiento').datepicker({
                format: 'dd/mm/yyyy',
                language: 'es',
                autoclose: true,
                endDate: new Date(),
                startView: 2,
                orientation: 'bottom'
            });

            // Función de validación
            function validarCampo(id, validacion, errorId) {
                const valor = $(id).val().trim();
                if (!validacion(valor)) {
                    $(id).addClass('is-invalid');
                    $(errorId).show();
                    return false;
                } else {
                    $(id).removeClass('is-invalid');
                    $(errorId).hide();
                    return true;
                }
            }

            // Limpiar errores al escribir
            $('input, select').on('input change', function() {
                $(this).removeClass('is-invalid');
                $(this).siblings('.error-message').hide();
            });

            // Validación del formulario
            
           
                
           
        });