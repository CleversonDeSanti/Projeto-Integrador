// Função para exibir os detalhes de um membro
function showDetails(memberId) {
    // Esconde todos os detalhes
    const details = document.querySelectorAll('.member-details');
    details.forEach(detail => detail.classList.remove('show'));

    // Mostra o detalhe do membro clicado
    const memberDetail = document.getElementById(memberId);
    if (memberDetail) {
        memberDetail.classList.add('show');
    }
}
