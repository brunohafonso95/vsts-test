const fs = require('fs');
const readline = require('readline');
const util = require('./util');

function generateAllYmlFiles(files) {
    util.createOutputFolders(['yamlFiles', 'jsonFiles', 'mdFiles']);
    util.createAllFiles(files, "yamlFiles", "yaml");
    files.map(file => {
        if(file.toString().includes('.java')) {
            readJavaFiles(file); 
        } else if(file.toString().includes('.py')) { 
            readPythonFiles(file);
        }
    });
}

function readJavaFiles(file) {
        let fileName = util.formatFileName(file);
        fileName = fileName.toString().replace('.', '').replace(/java/g, '');
        let rd = readline.createInterface({
            input: fs.createReadStream(`${file}`), 
            console: false
        });
        rd.on('line', function(line) {
            if(line.toString().includes("///")) {
                let lineContent = line.toString().replace("///","");
                if(lineContent.includes("- methodDescription:") || lineContent.includes("- classDescription:")) {
                    lineContent = lineContent.trim();
                } else {
                    lineContent = "    " + lineContent.trim();
                }
                fs.appendFileSync(`./yamlFiles/${fileName}.yaml`, lineContent + '\n', function(err) {
                    if(err) throw err;
                });  
            }     
        });
        console.log(`${fileName}.yaml gerado com sucesso!`);
}

function readPythonFiles(file) {
        let fileName = util.formatFileName(file);
        fileName = fileName.toString().replace('.', '').replace(/py/g, '');
        let rd = readline.createInterface({
            input: fs.createReadStream(`${file}`), 
            console: false
        });
        rd.on('line', function(line) {
            if(line.toString().includes("###")) {
                let lineContent = line.toString().replace("###","");
                if(lineContent.includes("- methodDescription:") || lineContent.includes("- classDescription:")) {
                    lineContent = lineContent.trim();
                } else {
                    lineContent = "    " + lineContent.trim();
                }
                fs.appendFileSync(`./yamlFiles/${fileName}.yaml`, lineContent + '\n', function(err) {
                    if(err) throw err;
                });  
            }     
        });
        console.log(`${fileName}.yaml gerado com sucesso!`);
}

//generateAllYmlFiles(util.getAllProjectFiles('./'));

module.exports = {
    generateAllYmlFiles 
}
