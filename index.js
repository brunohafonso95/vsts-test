const util = require('./util');
const yaml = require('./yaml');
const json = require('./json');
const md = require('./md');
const projectFiles = util.getAllProjectFiles('./');


util.createOutputFolders(['yamlFiles', 'jsonFiles', 'mdFiles']);

setTimeout(function() {
    yaml.generateAllYmlFiles(projectFiles);
}, projectFiles.length * 30);


setTimeout(function() {
    json.generateAllJsonFiles(util.getAllFolderFiles('./yamlFiles'));
}, projectFiles.length * 75); 



setTimeout(function() {
    md.generateAllMdFiles(util.getAllFolderFiles('./jsonFiles'));
}, projectFiles.length * 150);
