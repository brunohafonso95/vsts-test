const fs = require('fs');
const readline = require('readline');
const util = require('./util');

/*
* inicio funções de formatação de markdown
*/

function methodTitle(title) {
    return `### ${title} \n---\n`;
}

function methodDescription(description) {
    return `${description}\n`;
}

function methodParameter(parameterType, parameterName) {
    const parameters = parameterName.toString().split(',');
    let returnString = "";
    parameters.map((parameter) => {
        returnString += `> <span style="color: blue;">**Parâmetro**</span>: <code>**${parameterType}**</code> ${parameter}\n`;        
    });
    return returnString;
}

function methodExample(codeExample) {
    return "Ex:" + "\n" + "```java" + "\n" + codeExample.split("; ").join("\n") + "\n" + "```" + "\n";
}

function exceptionDescription(exceptionDescription) {
    return `${exceptionDescription}:\n`;
}

function exceptionMessage(exceptionMessage) {
    return `${exceptionMessage}\n`;
}

function returnDescription(returnDescription) {
    return `${returnDescription}\n`;
}

function returnType(returnType) {
    return `> <span style="color: green;">**Return**</span>: <code>**${returnType}**</code>\n`
}

/*
* fim funções de formatação de markdown
*/

function chechObjectProperty(prop, propValue) {
    if(prop === "title") {
        return methodTitle(propValue);
    } else if(prop.toLowerCase() === "text_description") {
        return methodDescription(propValue);
    } else if(prop.toLowerCase() === "parameters") {
        return methodParameter("int", propValue);
    } else if(prop.toLowerCase() === "ex") {
        return methodExample(propValue);
    } else if(prop.toLowerCase() === "Exception_description") {
        return exceptionDescription(propValue);
    } else if(prop.toLowerCase() === "Exception") {
        return exceptionMessage(propValue)
    } else if(prop === "return_description") {
        return returnDescription(propValue);
    } else if(prop.toLowerCase() === "return") {
        return returnType(propValue);
    }
}

function generateAllMdFiles(files) {
    util.createAllFiles(files, "./mdFiles", "md"); 
    files.map(file => {
        var fileName = file.toString().replace(/[^\w\s]/gi, '').replace(/json/g, '');
        fs.readFile(`./jsonFiles/${file}`, 'utf8', (err, jsonContent) => {
            if(err) throw err;
            if(jsonContent != "undefined") {
                fileObjetcContent = JSON.parse(jsonContent);
                fileObjetcContent.map(obj => {
                    for(let prop in obj.methodDescription) {
                        var lineContent = chechObjectProperty(prop, obj.methodDescription[prop]);
                        fs.appendFileSync(`./mdFiles/${fileName}.md`, lineContent + "\n", function(err) {
                            if(err) throw err;
                        });
                    }
                });
            }
        });
        console.log(`${fileName}.md gerado com sucesso!`);
    });
}

//generateAllMdFiles(util.getAllFolderFiles('./jsonFiles'))

module.exports = {
    generateAllMdFiles
}