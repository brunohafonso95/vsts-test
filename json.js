const fs = require('fs');
const yaml = require('js-yaml');
const util = require('./util');

function generateAllJsonFiles(files) {
    util.createAllFiles(files, "jsonFiles", "json"); 
    files.map(file => {
        var fileName = file.toString().replace(/[^\w\s]/gi, '').replace(/yaml/g, '');
        var obj = yaml.load(fs.readFileSync(`./yamlFiles/${file}`, {encoding: 'utf-8'}));
        fs.writeFileSync(`./jsonFiles/${fileName}.json`, JSON.stringify(obj, null, 2));
        console.log(`${fileName}.json gerado com sucesso!`);
    });
}

//generateAllJsonFiles(util.getAllFolderFiles("./yamlFiles"));

module.exports = {
    generateAllJsonFiles
}