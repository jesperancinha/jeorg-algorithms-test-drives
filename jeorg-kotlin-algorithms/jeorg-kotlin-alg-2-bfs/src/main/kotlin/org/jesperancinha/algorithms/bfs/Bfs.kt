package org.jesperancinha.algorithms.bfs

import org.jesperancinha.algorithms.bfs.model.Station

fun main(args: Array<String>) {
    val railwaySystemMap = createRailwaySystem()
    println(railwaySystemMap)
}

private fun createRailwaySystem(): HashMap<String, Station> {

    val olhao = Station("Olhão")
    val faro = Station("Faro")
    val tavira = Station("Tavira")
    val vilaReal = Station("Vila Real de Santo António")
    val tunes = Station("Tunes")
    val portimao = Station("Portimão")
    val lagos = Station("Lagos")
    val funcheira = Station("Funcheira")
    val lx = Station("Lisboa")
    val sintra = Station("Sintra")
    val cascais = Station("Cascais")
    val azambuja = Station("Azambuja")
    val vendasNovas = Station("Vendas Novas")
    val setubal = Station("Setúbal")
    val casaBranca = Station("Casa Branca")
    val evora = Station("Évora")
    val beja = Station("Beja")
    val santarem = Station("Santarém")
    val entroncamento = Station("Entroncamento")
    val abrantes = Station("Abrantes")
    val tomar = Station("Tomar")
    val portalegre = Station("Portalegre")
    val casteloBranco = Station("Castelo Branco")
    val covilha = Station("Covilhã")
    val elvas = Station("Elvas")
    val coimbra = Station("Coimbra")
    val figureiraFoz = Station("Figueira da Foz")
    val leiria = Station("Leiria")
    val caldasDaRainha = Station("Caldas da Rainha")
    val pampilhosa = Station("Pampilhosa")
    val guarda = Station("Guarda")
    val vilarFormoso = Station("Vilar Formoso")
    val aveiro = Station("Aveiro")
    val agueda = Station("Águeda")
    val sernadaVouga = Station("Sernada do Vouga")
    val oliveiraDeAzemeis = Station("Oliveira de Azeméis")
    val espinho = Station("Espinho")
    val porto = Station("Porto")
    val caide = Station("Caíde")
    val regua = Station("Régua")
    val tua = Station("Tua")
    val pocinho = Station("Pocinho")
    val guimaraes = Station("Guimarães")
    val braga = Station("Braga")
    val barcelos = Station("Barcelos")
    val vianaCastelo = Station("Viana do Castelo")
    val valenca = Station("Valença")

    val railMap = hashMapOf<String, Station>(
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