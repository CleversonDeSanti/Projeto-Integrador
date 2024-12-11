function showDetails(memberId) {
    // Oculta todos os detalhes visíveis
    const allDetails = document.querySelectorAll('.member-details');
    allDetails.forEach(detail => {
        detail.classList.remove('show');
    });

    // Exibe o detalhe correspondente ao membro clicado
    const memberDetail = document.getElementById(memberId);
    if (memberDetail) {
        memberDetail.classList.add('show');
    }

}
