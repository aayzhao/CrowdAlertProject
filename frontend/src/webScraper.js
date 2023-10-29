const functions = require('firebase-functions');
const express = require('express');
const axios = require('axios');
const cors = require('cors');

const app = express();
app.use(cors());

const NEWS_API_KEY = 'ea385a29b5a3408a82d869058b61c5db';
const NEWS_API_URL = 'https://newsapi.org/v2/everything';

app.get('/news', async (req, res) => {
    try {
        const location = req.query.location || '';
        const response = await axios.get(NEWS_API_URL, {
            params: {
                apiKey: NEWS_API_KEY,
                q: location,
            }
        });
        res.json(response.data);
    } catch (error) {
        res.status(500).send(error.message);
    }
});

exports.app = functions.https.onRequest(app);
