const fs = require('fs');
const walkSync = require('walk-sync');

function getAllFolderFiles(path) {
    return fs.readdirSync(path);
}

function createOutputFolders(listFolders) {
    listFolders.map(folder => {
        if(!fs.existsSync(folder)) {
            fs.mkdirSync(folder);
        }
    });
}

function getAllProjectFiles(path) {
    return walkSync(path).filter(file => {
        return !fs.statSync(file).isDirectory();
    });
}

function formatFileName(fileName) {
    let name = fileName.toString().split('/').pop();
    return name;
}

function createAllFiles(listFiles, path, extension) {
    listFiles.map(file => {
        if(file.toString().includes('.java')) {
            createJavaFile(formatFileName(file), path, extension);
        } else if(file.toString().includes('.py')) {
            createPythonFile(formatFileName(file), path, extension);
        }
    });
}

function createJavaFile(file, path, extension) {
    if(fileExist(file)) {
        var fileName = file.toString().replace(/[^\w\s]/gi, '').replace(/java/g, '');
        fs.writeFileSync(`./${path}/${fileName}.${extension}`, "");
    } else {
        var fileName = file.toString().replace(/[^\w\s]/gi, '').replace(/java/g, '');
        fs.writeFileSync(`./${path}/${fileName}.${extension}`, "");
    }
}

function createPythonFile(file, path, extension) {
    if(fileExist(file)) {
        var fileName = file.toString().replace('.', '').replace(/py/g, '');
        fs.writeFileSync(`./${path}/${fileName}.${extension}`, "");
    } else {
        var fileName = file.toString().replace('.', '').replace(/py/g, '');
        fs.writeFileSync(`./${path}/${fileName}.${extension}`, "");
    }
}

function fileExist(file)  {
    fs.exists(file, (exists) => {
        if(exists) {
            return true;
        } else {
            return false;
        }
    });
}

module.exports = {
    getAllFolderFiles,
    getAllProjectFiles,
    formatFileName,
    createAllFiles,
    fileExist,
    createOutputFolders
};