 $(document).ready(function() {
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
            $('#adminForm').on('submit', function(e) {
                e.preventDefault();
                let isValid = true;

                // Validar documento
                isValid &= validarCampo('#adminDocumento', 
                    val => val !== '' && /^\d+/.test(val), 
                    '#errorAdminDocumento');

                // Validar nombre
                isValid &= validarCampo('#adminNombre', 
                    val => val !== '', 
                    '#errorAdminNombre');

                // Validar apellido
                isValid &= validarCampo('#adminApellido', 
                    val => val !== '', 
                    '#errorAdminApellido');

                // Validar correo
                isValid &= validarCampo('#adminCorreo', 
                    val => /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(val), 
                    '#errorAdminCorreo');

                // Validar teléfono
                isValid &= validarCampo('#adminTelefono', 
                    val => val !== '' && /^\d+$/.test(val), 
                    '#errorAdminTelefono');

                // Validar fecha
                isValid &= validarCampo('#adminFecha', 
                    val => val !== '', 
                    '#errorAdminFecha');

                // Validar género
                isValid &= validarCampo('#adminGenero', 
                    val => val !== '', 
                    '#errorAdminGenero');

                // Validar rol
                isValid &= validarCampo('#adminRol', 
                    val => val !== '', 
                    '#errorAdminRol');

                if (isValid) {
                    alert('¡Datos guardados exitosamente!');
                }
            });
        });

        function eliminarUsuario() {
            if (confirm('¿Está seguro de que desea eliminar este usuario?')) {
                alert('Usuario eliminado exitosamente');
                // Aquí iría la lógica para eliminar el usuario
            }
        }

        function actualizarUsuario() {
            alert('Datos actualizados exitosamente');
            // Aquí iría la lógica para actualizar los datos
        }

        function cerrarSesion() {
            if (confirm('¿Está seguro de que desea cerrar sesión?')) {
                window.location.href = 'index.html';
            }
        }