function Alert(message, icon = 'success') {
    Swal.fire({
        position: 'center',
        icon: icon,
        title: message,
        showConfirmButton: false,
        timer: 2500
    });
}