#!/usr/bin/env node

const util = require('./util');
const yaml = require('./yaml');
const json = require('./json');
const md = require('./md');

const projectFiles = util.getAllProjectFiles('./');
const yamlFiles = util.getAllFolderFiles('./yamlFiles');
const jsonFiles = util.getAllFolderFiles('./jsonFiles');

console.log(projectFiles.length);

yaml.generateAllYmlFiles(projectFiles);

setTimeout(function() {
    json.generateAllJsonFiles(yamlFiles);
}, yamlFiles.length * 500);

setTimeout(function() {
    md.generateAllMdFiles(jsonFiles);
}, jsonFiles.length * 500);