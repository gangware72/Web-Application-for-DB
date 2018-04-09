/* 
 * creates a new XMLHttpRequest object which is the backbone of AJAX  
 * or returns false if the browser doesn't support it 
 */
function getXMLHttpRequest() {
    var xmlHttpReq;
    // to create XMLHttpRequest object in non-Microsoft browsers  
    if (window.XMLHttpRequest) {
        xmlHttpReq = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        try {
            //to create XMLHttpRequest object in later versions of Internet Explorer  
            xmlHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (exp1) {
            try {
                //to create XMLHttpRequest object in later versions of Internet Explorer  
                xmlHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (exp2) {
                //xmlHttpReq = false;  
                alert("Exception in getXMLHttpRequest()!");
            }
        }
    }
    return xmlHttpReq;
}

/* 
 * AJAX call starts with this function 
 */
function UpdateBook(id) {
    var tagName = id.name;
    var tagValue = id.value;

    var title = "t-"+tagName;
    var authors = "a-"+tagName;
    var pubDate = "p-"+tagName;
    var desc = "d-"+tagName;
    var image = "i-"+tagName;
    var preview = "pre-"+tagName;
    
    //alert(tagName + "---" + tagValue);
    
    title = document.getElementById(title).value;    
    authors = document.getElementById(authors).value;
    pubDate = document.getElementById(pubDate).value;
    desc = document.getElementById(desc).value;
    image = document.getElementById(image).value;
    preview = document.getElementById(preview).value;
            
    
    var tagNameResponse = tagName + "_r";
    var url = "saveBooks.jsp?opt=1&t=" + title+"&a="+authors+"&p="+pubDate+"&d="+desc+"&i="+image+"&pre="+preview;
    //alert(url);
    
    var xmlHttpRequest = getXMLHttpRequest();
    xmlHttpRequest.onreadystatechange = getReadyStateHandler(xmlHttpRequest, tagNameResponse);
    xmlHttpRequest.open("GET", url, true);
    xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xmlHttpRequest.send(null);
}

/* 
 * Returns a function that waits for the state change in XMLHttpRequest 
 */
function getReadyStateHandler(xmlHttpRequest, tagR) {
    // an anonynous function returned  
    // it listens to the XMLHttpRequest instance  
    return function () {
        if (xmlHttpRequest.readyState == 4) {
            if (xmlHttpRequest.status == 200) {
                document.getElementById(tagR).innerHTML = xmlHttpRequest.responseText;
                alert(xmlHttpRequest.responseText);
            } else {
                alert("Http error " + xmlHttpRequest.status + ":" + xmlHttpRequest.statusText);
            }
        }
    };
}  