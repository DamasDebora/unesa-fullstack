const receitas = './recipes.json'
const catalogo = document.querySelector('#pnlCatalogo')

async function getCard(){
    const response = await fetch(receitas)
    const data = await response.json()

    data.map((receita) => {
        const card =  document.createElement('div')
        card.classList.add('card-body');

        const hr = document.createElement('hr')

        const img = document.createElement('img')
        img.classList.add('card-image-top')
        img.src = receita.imagem
        card.appendChild(img)

        const title = document.createElement('h1')
        title.classList.add('card-title')
        title.innerText = receita.titulo
        card.appendChild(title)

        const ul = getListaIngredientes(receita.ingredientes)
        card.appendChild(ul)
        card.appendChild(hr)

        const divTexto = document.createElement('div')
        divTexto.classList.add('card-text')
        divTexto.innerText = receita.preparo
        card.appendChild(divTexto)

        catalogo.appendChild(card)            
    })
}

function getListaIngredientes(ingredientes){    

    const ul = document.createElement('ul')
  
    ingredientes.forEach((ingrediente) => {

        let li = document.createElement('li')

        li.innerText = ingrediente
        ul.appendChild(li)       
    })
    return ul
}




