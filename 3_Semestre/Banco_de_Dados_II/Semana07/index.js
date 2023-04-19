const cors = require('cors')
require('dotenv').config()
const express = require('express')
const { MongoClient } = require('mongodb');

async function main() {
    /**
      * Connection URI. Update <username>, <password>, and <your-cluster-url> to reflect your cluster.
      * See https://docs.mongodb.com/ecosystem/drivers/node/ for more details
    **/
    const uri = process.env.CONNECTION_URI;
    const client = new MongoClient(uri);
    const app = express()
    const PORT = 5000

    // Connect to the MongoDB cluster
    await client.connect();

    app.use(cors({
        origin: 'http://127.0.0.1:5500'
    }))

    app.listen(PORT, () => {
        console.log(`Running on http://localhost:${PORT}`)
    })

    app.get('/', async (_, res) => {
        const documents = await client.db("sample_airbnb").collection("listingsAndReviews").find({}).toArray()
        const data = documents.map(doc => JSON.stringify(doc))
        return res.send(data)
    })
}

main()

async function listDatabases(client) {
    databasesList = await client.db().admin().listDatabases();
    console.log("Databases:");
    databasesList.databases.forEach(db => {
        console.log(` - ${db.name}`)
    });
};