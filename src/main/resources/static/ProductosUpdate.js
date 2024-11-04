document.addEventListener('DOMContentLoaded', function () {

    // Fetch and insert the header and footer
    fetch('header.html')
        .then(response => response.text())
        .then(data => {
            const parser = new DOMParser();
            const doc = parser.parseFromString(data, 'text/html');
            const header = doc.querySelector('header');
            const footer = doc.querySelector('footer');

            if (header) {
                document.body.insertAdjacentElement('afterbegin', header);
            }

            if (footer) {
                document.body.insertAdjacentElement('beforeend', footer);
            }

            // Add event listener for navbar toggle
            const navbarToggle = document.querySelector('.navbar-toggle');
            const navbarMenu = document.querySelector('.navbar-menu');

            if (navbarToggle && navbarMenu) {
                navbarToggle.addEventListener('click', () => {
                    navbarMenu.classList.toggle('active');
                });
            } else {
                console.error('Element with class .navbar-toggle or .navbar-menu not found.');
            }
        })
        .catch(error => {
            console.error('Error fetching header.html:', error);
        });

    // Ocultar los formularios al cargar la página
    document.getElementById('formCreate').style.display = 'none';
    document.getElementById('formUpdate').style.display = 'none';
    document.getElementById('formDelete').style.display = 'none';

    // Función para mostrar el formulario de creación
    document.getElementById('btnCreate').addEventListener('click', function () {
        document.getElementById('formCreate').style.display = 'block';
    });

    // Función para mostrar el formulario de actualización
    function mostrarFormularioActualizar(row) {
        document.getElementById("idmodificar").value = row.cells[0].innerHTML;
        document.getElementById("nombremodificar").value = row.cells[1].innerHTML;
        document.getElementById("costomodificar").value = row.cells[2].innerHTML;
        document.getElementById("preciomodificar").value = row.cells[3].innerHTML;
        document.getElementById("descuentomodificar").value = row.cells[4].innerHTML;
        document.getElementById("promocionmodificar").checked = row.cells[5].innerHTML === 'Sí';
        document.getElementById("fecha_de_compra_modificar").value = row.cells[6].innerHTML;
        document.getElementById("vencimientomodificar").value = row.cells[7].innerHTML;
        document.getElementById("unidadesVendidasmodificar").value = row.cells[8].innerHTML;
        document.getElementById("unidadesExistentesmodificar").value = row.cells[9].innerHTML;
        document.getElementById('formUpdate').style.display = 'block';
    }

    // Función para mostrar el formulario de eliminación
    function mostrarFormularioEliminar(row) {
        document.getElementById("ideliminar").value = row.cells[0].innerHTML;
        document.getElementById("nombreeeliminar").value = row.cells[1].innerHTML;
        document.getElementById("costoeliminar").value = row.cells[2].innerHTML;
        document.getElementById("precioeliminar").value = row.cells[3].innerHTML;
        document.getElementById("descuentoeliminar").value = row.cells[4].innerHTML;
        document.getElementById("promocioneliminar").checked = row.cells[5].innerHTML === 'Sí';
        document.getElementById("fecha_de_compra_eliminar").value = row.cells[6].innerHTML;
        document.getElementById("vencimientoeliminar").value = row.cells[7].innerHTML;
        document.getElementById("unidadesVendidaseliminar").value = row.cells[8].innerHTML;
        document.getElementById("unidadesExistenteseliminar").value = row.cells[9].innerHTML;
        document.getElementById('formDelete').style.display = 'block';
    }

    // Agregar eventos a los botones de la tabla
    var table = document.getElementById("tablaDatos");
    for (var i = 1; i < table.rows.length; i++) {
        table.rows[i].querySelector('.btn-warning').onclick = function () {
            mostrarFormularioActualizar(this.parentElement.parentElement);
        };
        table.rows[i].querySelector('.btn-danger').onclick = function () {
            mostrarFormularioEliminar(this.parentElement.parentElement);
        };
    }

    // Ocultar los formularios después de enviar
    document.querySelector('#formCreate form').onsubmit = function () {
        document.getElementById('formCreate').style.display = 'none';
    };
    document.querySelector('#formUpdate form').onsubmit = function () {
        document.getElementById('formUpdate').style.display = 'none';
    };
    document.querySelector('#formDelete form').onsubmit = function () {
        document.getElementById('formDelete').style.display = 'none';
    };
});
