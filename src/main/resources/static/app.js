// monta uma lista <ol> com os pacientes
function mostrar(idLista, pacientes) {
    const lista = document.getElementById(idLista);
    lista.innerHTML = "";
    pacientes.forEach(p => {
        const item = document.createElement("li");
        item.className = p.cor;
        item.textContent = `${p.nome} - ${p.idade} anos - ${p.cor}`;
        lista.appendChild(item);
    });
}

// busca as duas listas no back-end
async function atualizar() {
    const chegada = await fetch("/api/chegada").then(r => r.json());
    const fila = await fetch("/api/fila").then(r => r.json());
    mostrar("chegada", chegada);
    mostrar("fila", fila);
}

document.getElementById("form").addEventListener("submit", async (e) => {
    e.preventDefault();
    const paciente = {
        nome: document.getElementById("nome").value,
        idade: Number(document.getElementById("idade").value),
        cor: document.getElementById("cor").value
    };
    await fetch("/api/pacientes", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(paciente)
    });
    e.target.reset();
    atualizar();
});

document.getElementById("chamar").addEventListener("click", async () => {
    const resposta = await fetch("/api/chamar", { method: "POST" });
    const texto = document.getElementById("chamado");
    if (resposta.status === 204) {
        texto.textContent = "Fila vazia";
    } else {
        const p = await resposta.json();
        texto.textContent = `Chamado: ${p.nome} (${p.cor}, ${p.idade} anos)`;
    }
    atualizar();
});

atualizar();
