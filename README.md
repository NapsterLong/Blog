#NapsterLong's person blog!

upload a file or image:
    rootPath(application.yml)+imagePathFormat(config.json)
    /data1/resources/   /picture/{yyyy}{mm}{dd}/{time}{rand:6}"

show the file or image
    imagePathFormat(config.json)+suffix(auto)
    /picture/{yyyy}{mm}{dd}/{time}{rand:6}" .jpg

search the file/image lists 
    rootPath(application.yml)+fileManagerListPath(config.json)
    /data1/resources/ file


