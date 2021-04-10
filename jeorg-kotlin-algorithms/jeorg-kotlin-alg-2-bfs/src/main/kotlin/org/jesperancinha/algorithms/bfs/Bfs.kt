package org.jesperancinha.algorithms.bfs

import org.jesperancinha.algorithms.bfs.model.Station
import org.jesperancinha.algorithms.bfs.model.TravelNode
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer

fun main(args: Array<String>) {
    val railwaySystemMap = createRailwaySystem()
    outRoutes("olhao", "oliveiraDeAzemeis", railwaySystemMap)
    outRoutes("olhao", "valenca", railwaySystemMap)
    outRoutes("olhao", "lx", railwaySystemMap)
    outRoutes("olhao", "portimao", railwaySystemMap)
    outRoutes("olhao", "lagos", railwaySystemMap)
    outRoutes("olhao", "vilaReal", railwaySystemMap)
    outRoutes("olhao", "guarda", railwaySystemMap)
    outRoutes("olhao", "covilha", railwaySystemMap)
}

private fun outRoutes(
    startName: String,
    endName: String,
    railwaySystemMap: HashMap<String, Station>
) {
    val start = railwaySystemMap[startName]
    val end = railwaySystemMap[endName]
    ConsolerizerComposer.out()
        .green("🚂 - We start travelling from %s", start)
    val routeList = calculateRoutes(start!!, end!!, railwaySystemMap)
    ConsolerizerComposer.outSpace().yellow(routeList)
    ConsolerizerComposer.out()
        .red("🚂 - We stop travelling at %s", end)
}

private fun convertToRoutes(
    routeList: MutableList<TravelNode>,
    railwaySystemMap: HashMap<String, Station>
): List<List<Station?>> {
    val routes = routeList.map {
        val fastestRouteList = ArrayDeque<Station?>()
        fastestRouteList.addFirst(railwaySystemMap[it.key])
        var up = it;
        do {
            up = up.back!!;
            fastestRouteList.addFirst(railwaySystemMap[up.key])
        } while (up.back != null)
        fastestRouteList.toList()
    }
    return routes
}

/**
 * procedure BFS(G, root) is
 *     let Q be a queue
 *     label root as discovered
 *     Q.enqueue(root)
 *     while Q is not empty do
 *         v := Q.dequeue()
 *         if v is the goal then
 *             return v
 *         for all edges from v to w in G.adjacentEdges(v) do
 *             if w is not labeled as discovered then
 *                 label w as discovered
 *                 Q.enqueue(w)
 **/
fun calculateRoutes(start: Station, end: Station, railwaySystemMap: HashMap<String, Station>): List<List<Station?>> {
    val routes = mutableListOf<TravelNode>()
    val queue = ArrayDeque<TravelNode>()
    val currentNode = TravelNode(start.name, start.key)
    val visited = mutableMapOf<String, Boolean>()

    start.linkedStations.forEach {

        val element = TravelNode(it.name, it.key)
        queue.addFirst(element)
        visited[it.name] = true
        currentNode.linkedStations.add(element)
        element.back = currentNode
        if (it.key === end.key) {
            routes.add(element)
        }

    }

    resolve(queue, routes, end, visited, railwaySystemMap)
    return convertToRoutes(routes, railwaySystemMap)
}

fun resolve(
    queue: ArrayDeque<TravelNode>,
    routes: MutableList<TravelNode>,
    end: Station,
    visited: MutableMap<String, Boolean>,
    railwaySystemMap: HashMap<String, Station>
) {
    if (queue.isNotEmpty()) {
        val removeLast = queue.removeLast()
        val station = railwaySystemMap[removeLast.key]
        station!!.linkedStations.forEach {
            if (visited[it.key] === null || !visited[it.key]!!) {
                val element = TravelNode(it.name, it.key)
                queue.addFirst(element)
                visited[it.key] = true
                element.back = removeLast

                if (it.key === end.key) {
                    routes.add(element)
                }
            }
        }
        resolve(queue, routes, end, visited, railwaySystemMap)
    }
}


private fun createRailwaySystem(): HashMap<String, Station> {

    val olhao = Station("Olhão", "olhao")
    val faro = Station("Faro", "faro")
    val tavira = Station("Tavira", "tavira")
    val vilaReal = Station("Vila Real de Santo António", "vilaReal")
    val tunes = Station("Tunes", "tunes")
    val portimao = Station("Portimão", "portimao")
    val lagos = Station("Lagos", "lagos")
    val funcheira = Station("Funcheira", "funcheira")
    val lx = Station("Lisboa", "lx")
    val sintra = Station("Sintra", "sintra")
    val cascais = Station("Cascais", "cascais")
    val azambuja = Station("Azambuja", "azambuja")
    val vendasNovas = Station("Vendas Novas", "vendasNovas")
    val setubal = Station("Setúbal", "setubal")
    val casaBranca = Station("Casa Branca", "casaBranca")
    val evora = Station("Évora", "evora")
    val beja = Station("Beja", "beja")
    val santarem = Station("Santarém", "santarem")
    val entroncamento = Station("Entroncamento", "entroncamento")
    val abrantes = Station("Abrantes", "abrantes")
    val tomar = Station("Tomar", "tomar")
    val portalegre = Station("Portalegre", "portalegre")
    val casteloBranco = Station("Castelo Branco", "casteloBranco")
    val covilha = Station("Covilhã", "covilha")
    val elvas = Station("Elvas", "elvas")
    val coimbra = Station("Coimbra", "coimbra")
    val figureiraFoz = Station("Figueira da Foz", "figureiraFoz")
    val leiria = Station("Leiria", "leiria")
    val caldasDaRainha = Station("Caldas da Rainha", "caldasDaRainha")
    val pampilhosa = Station("Pampilhosa", "pampilhosa")
    val guarda = Station("Guarda", "guarda")
    val vilarFormoso = Station("Vilar Formoso", "vilarFormoso")
    val aveiro = Station("Aveiro", "aveiro")
    val agueda = Station("Águeda", "agueda")
    val sernadaVouga = Station("Sernada do Vouga", "sernadaVouga")
    val oliveiraDeAzemeis = Station("Oliveira de Azeméis", "oliveiraDeAzemeis")
    val espinho = Station("Espinho", "espinho")
    val porto = Station("Porto", "porto")
    val caide = Station("Caíde", "caide")
    val regua = Station("Régua", "regua")
    val tua = Station("Tua", "tua")
    val pocinho = Station("Pocinho", "pocinho")
    val guimaraes = Station("Guimarães", "guimaraes")
    val braga = Station("Braga", "braga")
    val barcelos = Station("Barcelos", "barcelos")
    val vianaCastelo = Station("Viana do Castelo", "vianaCastelo")
    val valenca = Station("Valença", "valenca")

    val railMap = hashMapOf(
        "olhao" to olhao,
        "faro" to faro,
        "tavira" to tavira,
        "vilaReal" to vilaReal,
        "tunes" to tunes,
        "portimao" to portimao,
        "lagos" to lagos,
        "funcheira" to funcheira,
        "lx" to lx,
        "sintra" to sintra,
        "cascais" to cascais,
        "azambuja" to azambuja,
        "vendasNovas" to vendasNovas,
        "setubal" to setubal,
        "casaBranca" to casaBranca,
        "evora" to evora,
        "beja" to beja,
        "santarem" to santarem,
        "entroncamento" to entroncamento,
        "abrantes" to abrantes,
        "tomar" to tomar,
        "portalegre" to portalegre,
        "casteloBranco" to casteloBranco,
        "covilha" to covilha,
        "elvas" to elvas,
        "coimbra" to coimbra,
        "figureiraFoz" to figureiraFoz,
        "leiria" to leiria,
        "caldasDaRainha" to caldasDaRainha,
        "pampilhosa" to pampilhosa,
        "guarda" to guarda,
        "vilarFormoso" to vilarFormoso,
        "aveiro" to aveiro,
        "agueda" to agueda,
        "sernadaVouga" to sernadaVouga,
        "oliveiraDeAzemeis" to oliveiraDeAzemeis,
        "espinho" to espinho,
        "porto" to porto,
        "caide" to caide,
        "regua" to regua,
        "tua" to tua,
        "pocinho" to pocinho,
        "guimaraes" to guimaraes,
        "braga" to braga,
        "barcelos" to barcelos,
        "vianaCastelo" to vianaCastelo,
        "valenca" to valenca
    )

    olhao.linkedStations.add(faro)
    olhao.linkedStations.add(tavira)

    tavira.linkedStations.add(vilaReal)
    tavira.linkedStations.add(olhao)

    vilaReal.linkedStations.add(tavira)

    faro.linkedStations.add(olhao)
    faro.linkedStations.add(tunes)

    tunes.linkedStations.add(faro)
    tunes.linkedStations.add(portimao)
    tunes.linkedStations.add(funcheira)

    portimao.linkedStations.add(tunes)
    portimao.linkedStations.add(lagos)

    lagos.linkedStations.add(portimao)

    funcheira.linkedStations.add(tunes)
    funcheira.linkedStations.add(lx)
    funcheira.linkedStations.add(vendasNovas)
    funcheira.linkedStations.add(setubal)

    vendasNovas.linkedStations.add(casaBranca)
    vendasNovas.linkedStations.add(funcheira)
    vendasNovas.linkedStations.add(setubal)
    vendasNovas.linkedStations.add(lx)

    casaBranca.linkedStations.add(vendasNovas)
    casaBranca.linkedStations.add(evora)
    casaBranca.linkedStations.add(beja)

    evora.linkedStations.add(casaBranca)

    beja.linkedStations.add(casaBranca)

    lx.linkedStations.add(funcheira)
    lx.linkedStations.add(setubal)
    lx.linkedStations.add(vendasNovas)
    lx.linkedStations.add(azambuja)
    lx.linkedStations.add(sintra)
    lx.linkedStations.add(cascais)

    cascais.linkedStations.add(lx)

    sintra.linkedStations.add(caldasDaRainha)
    sintra.linkedStations.add(lx)

    caldasDaRainha.linkedStations.add(leiria)
    caldasDaRainha.linkedStations.add(sintra)

    leiria.linkedStations.add(figureiraFoz)
    leiria.linkedStations.add(caldasDaRainha)
    leiria.linkedStations.add(coimbra)

    azambuja.linkedStations.add(lx)
    azambuja.linkedStations.add(santarem)

    santarem.linkedStations.add(entroncamento)
    santarem.linkedStations.add(azambuja)

    entroncamento.linkedStations.add(abrantes)
    entroncamento.linkedStations.add(santarem)
    entroncamento.linkedStations.add(tomar)
    entroncamento.linkedStations.add(coimbra)

    abrantes.linkedStations.add(entroncamento)
    abrantes.linkedStations.add(casteloBranco)
    abrantes.linkedStations.add(portalegre)

    casteloBranco.linkedStations.add(covilha)
    casteloBranco.linkedStations.add(abrantes)

    covilha.linkedStations.add(casteloBranco)

    portalegre.linkedStations.add(abrantes)
    portalegre.linkedStations.add(elvas)

    elvas.linkedStations.add(portalegre)

    tomar.linkedStations.add(coimbra)
    tomar.linkedStations.add(entroncamento)

    coimbra.linkedStations.add(figureiraFoz)
    coimbra.linkedStations.add(leiria)
    coimbra.linkedStations.add(tomar)
    coimbra.linkedStations.add(entroncamento)
    coimbra.linkedStations.add(pampilhosa)

    pampilhosa.linkedStations.add(guarda)
    pampilhosa.linkedStations.add(coimbra)
    pampilhosa.linkedStations.add(aveiro)

    guarda.linkedStations.add(pampilhosa)
    guarda.linkedStations.add(vilarFormoso)

    vilarFormoso.linkedStations.add(guarda)

    aveiro.linkedStations.add(pampilhosa)
    aveiro.linkedStations.add(agueda)
    aveiro.linkedStations.add(espinho)

    agueda.linkedStations.add(aveiro)
    agueda.linkedStations.add(sernadaVouga)

    sernadaVouga.linkedStations.add(oliveiraDeAzemeis)
    sernadaVouga.linkedStations.add(agueda)

    oliveiraDeAzemeis.linkedStations.add(espinho)
    oliveiraDeAzemeis.linkedStations.add(sernadaVouga)

    espinho.linkedStations.add(oliveiraDeAzemeis)
    espinho.linkedStations.add(aveiro)
    espinho.linkedStations.add(porto)

    porto.linkedStations.add(espinho)
    porto.linkedStations.add(caide)
    porto.linkedStations.add(guimaraes)
    porto.linkedStations.add(braga)
    porto.linkedStations.add(barcelos)

    caide.linkedStations.add(regua)
    caide.linkedStations.add(porto)

    regua.linkedStations.add(caide)
    regua.linkedStations.add(tua)

    tua.linkedStations.add(regua)
    tua.linkedStations.add(pocinho)

    pocinho.linkedStations.add(tua)

    braga.linkedStations.add(barcelos)
    braga.linkedStations.add(guimaraes)
    braga.linkedStations.add(porto)

    guimaraes.linkedStations.add(braga)
    guimaraes.linkedStations.add(barcelos)
    guimaraes.linkedStations.add(porto)

    barcelos.linkedStations.add(braga)
    barcelos.linkedStations.add(guimaraes)
    barcelos.linkedStations.add(porto)
    barcelos.linkedStations.add(vianaCastelo)

    vianaCastelo.linkedStations.add(barcelos)
    vianaCastelo.linkedStations.add(valenca)

    valenca.linkedStations.add(vianaCastelo)

    return railMap
}