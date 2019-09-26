const express = require('express')
const app = express()

app.get('/', (req, res) => res.send('Server BBBBBBBBB'))

app.listen(4000, () => console.log('Example app listening on port 4000!'))
