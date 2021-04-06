import createPyramid from "./pyramid.js"


function startCalculation(startPositions, destination) {
    let firstNode = createPyramid(startPositions)
    calculateStartTriangle(firstNode,destination)
    console.log("This is how you move the plates in an Hanoi Tower");
    let startNode = firstNode
    console.log(startNode.positions)
    while (startNode.connections.length !== 0 && !compareArrayEquals(startNode.positions, destination)) {
        let i = startNode.connections.length - 1
        while (startNode.connections[i].connections.length === 0) {
            if (i > 0) {
                i--
            }
        }
        startNode = startNode.connections[i]
        console.log(startNode.positions)
    }
}


function calculateStartTriangle(firstNode,destination) {
    let nodeMap = new Map()
    calculateTriangle(firstNode,destination, null, nodeMap)
    console.log(firstNode)
}

function clone(nodeMap) {
    let newMap = new Map();

    nodeMap.forEach((value, key) =>{
        newMap.set(key, value)
    })
    return newMap;
}

function calculateTriangle(
    firstNode,
    destination,
    ignorePositions,
    nodeMap,
) {

    for (let i = 0; i <= 2; i++) {
        let calculatePyramidMovesResult = calculatePyramidMoves(firstNode.positions, ignorePositions, i)
        calculatePyramidMovesResult.forEach(move => {
            firstNode.connections.push(move)
        })
    }

    if(compareArrayEquals(firstNode.positions,destination)){
        return;
    }
    nodeMap.set(JSON.stringify(firstNode.positions), firstNode)
    if (firstNode.connections.length > 0) {
        firstNode.connections.forEach((pyramid) => {
            if (!nodeMap.get(JSON.stringify(pyramid.positions))) {
                calculateTriangle(pyramid, destination,firstNode.positions, clone(nodeMap))
            }
        });
    }
}

function calculatePyramidMoves(positions, ignorePositions, i) {
    let calcList = [];
    let canMoveIt = canMove(positions, i);
    if (canMoveIt) {
        if (i === 0) {
            for (let j = 0; j < positions.length; j++) {
                if (j + 1 !== positions[0]) {
                    let newPositions = JSON.parse(JSON.stringify(positions))
                    newPositions[0] = j + 1
                    if (!ignorePositions || !compareArrayEquals(ignorePositions, newPositions)) {
                        calcList.push(createPyramid(newPositions))
                    }
                }
            }
        }

        if (i === 1) {
            for (let j = 0; j < positions.length; j++) {
                if (j + 1 !== positions[0] && j + 1 !== positions[1]) {
                    let newPositions = JSON.parse(JSON.stringify(positions))
                    newPositions[1] = j + 1
                    if (!ignorePositions  || !compareArrayEquals(ignorePositions, newPositions)) {
                        calcList.push(createPyramid(newPositions))
                    }
                }
            }
        }

        if (i === 2) {
            for (let j = 0; j < positions.length; j++) {
                if (positions.indexOf(j + 1) === -1) {
                    let newPositions = JSON.parse(JSON.stringify(positions))
                    newPositions[2] = j + 1
                    if (!ignorePositions || !compareArrayEquals(ignorePositions, newPositions)) {
                        calcList.push(createPyramid(newPositions))
                    }
                }
            }
        }
    }
    return calcList
}

let canMove = (positions, i) => {
    if (i === 0) {
        return true;
    }
    for (let j = 0; j < i; j++) {
        if (positions[j] === positions[i]) {
            return false;
        }
    }
    return true;
}

function compareArrayEquals(a1, a2) {
    return a1 <= a2 && a1 >= a2;
}


export default startCalculation
