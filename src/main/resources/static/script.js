const url = "http://localhost:8080/livraria";
function salvar(){
    const livro = {
        titulo: document.getElementById("titulo").value,
        autor: document.getElementById("autor").value,
        preco: parseFloat(document.getElementById("preco").value), //converte o número em decimal
        estoque: parseInt(document.getElementById("estoque").value),
        isbn: document.getElementById("isbn").value
    };

    fetch (url, {method: "POST", headers:{"Content-Type":"application/json"}, body: JSON.stringify(livro)}).then(() => listar());
}

function listar(){
    fetch(url).then(res => res.json()).then(dados => const lista = document.getElementById("lista"))
}