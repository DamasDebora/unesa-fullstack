const swap = (vector, position1, position2) =>{
    let aux = vector[position1]
    vector[position1] = vector[position2]
    vector[position2] = aux
    return vector
}

const shuffle = (vector, exchanges) =>{
    upper_bound = vector.length-1
    lower_bound = 0 
    for(let i=0; i < exchanges; i++){
        let a = Math.floor(Math.random()*(upper_bound - lower_bound) + lower_bound);
        let b = Math.floor(Math.random()*(upper_bound - lower_bound) + lower_bound);

        vector = swap(vector, a, b)
    }
    return vector
}

const bubbleSort = vector => {
    for (let i = 0 ; i < vector.length; i++) {
        for (let j = 0 ; j < vector.length; j++) {
            if ( vector [j] > vector [j + 1 ]) {
               vector = swap(vector, j, j+1)
           }
       }
   }
   return vector
} 

const selectionSort = vector => {       
    for(let i = 0; i < vector.length; i++) {
        let min = i
        for(let j = i+1; j < vector.length; j++){
            if(vector[j] < vector[min]) {
                min=j
            }
         }
         if (min != i) {
            vector = swap(vector, i, min)    
        }
    }
    return vector
}

const quickSort = (vector, left, right) => {
    let index

    if(vector.length > 1){

        index = partition(vector, left, right)
        if (left < index - 1){
            vector = quickSort(vector, left, index -1)
        }
        if (index < right){
            vector = quickSort(vector, index, right)
        }
    }
    return vector
}

const partition = (vector, left, right) => {       
    const pivotValue = vector[right];
    let pivotIndex = left; 
    for (let i = left; i < right; i++) {
        if (vector[i] < pivotValue) {
 
        [vector[i], vector[pivotIndex]] = [vector[pivotIndex], vector[i]];

        pivotIndex++;
        }
    }
    [vector[pivotIndex], vector[right]] = [vector[right], vector[pivotIndex]] 
    return pivotIndex;
}


function toOrder(){   
    const valuesFromList = getValuesFromList()
    const mode = document.getElementById('mode').value
    let sortedValues
    if(mode == 'bubble'){        
        sortedValues = bubbleSort(valuesFromList)
    }else if(mode == 'selection'){
        sortedValues = selectionSort(valuesFromList)
    }else if ( mode == 'quick'){
        sortedValues = quickSort(valuesFromList, 0, valuesFromList.length-1)
    }
    updateList(sortedValues)
}

function toMix(){
    const valuesFromList = getValuesFromList()
    const unsortedValues = shuffle(valuesFromList, 100)
    if(mode == 'bubble'){        
        unsortedValues = bubbleSort(valuesFromList)
    }else if(mode == 'selection'){
        unsortedValues = selectionSort(valuesFromList)
    }else if ( mode == 'quick'){
        unsortedValues = quickSort(valuesFromList, 0, valuesFromList.length-1)
    }
    updateList(unsortedValues)

}

function toAdd(){
    //.value pega os valores dentro de text input
    const rawValues = document.getElementById('value').value
    // values recebe raw values, transformando string em int
    let values = rawValues.split(',').map((value) => parseInt(value))
    updateList(values);
}

function updateList(values){
    const ul = document.getElementById('values')
    ul.innerHTML = ''
    values.forEach(value => {
        const li = document.createElement('li')
        li.innerText = value
        ul.appendChild(li)        
    });
}

function getValuesFromList(){
    //pega 'imeditamente(>)' todos os lis dentro de values(ul)
    const lis = document.querySelectorAll('#values>li') 
    
    return Array.from(lis).map((value) => {
        return parseInt(value.innerText)
    })
}