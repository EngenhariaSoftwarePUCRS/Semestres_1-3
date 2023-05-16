db.viagens.find({
    "Partida.Bairro": "Floresta"
}, {
    "Carro_Codigo": {"Codigo": 1},
    "_id": 0
})

db.viagens.aggregate([
    {
        $unwind: "$Passageiros_CPF"
    },
    {
        $match: {
            "Partida.Bairro": "$Passageiros_CPF.Bairo"
        }
    },
    {
        $project: {
            "Passageiros_CPF.Nome": 1,
            "Carro_Codigo.Codigo": 1
        }
    }
])

db.viagens.aggregate([
    {
        $unwind: "$Passageiros_CPF"
    },
    {
        $group: {
            _id: "$Passageiros_CPF.CPF",
            "Nome Passageiro": {$first: "$Passageiros_CPF.Nome"},
            "Quilômetros Percorridos": {$sum: "$KMS"}
        }
    },
    {
        $sort: {
            "Quilômetros Percorridos": -1
        }
    }
])
