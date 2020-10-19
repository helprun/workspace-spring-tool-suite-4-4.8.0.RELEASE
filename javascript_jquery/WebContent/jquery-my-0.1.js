window.jQuery = function(selector) {
	if(typeof selector == 'string') {
		
	} else if(typeof selector == 'function') {
		window.addEventListener('load', selector);
	} else if(typeof selector == 'object') {
		
	}
	
	var elementNodeList = document.querySelectorAll(selector);
	var elementNode = document.querySelector(selector);
	
	var jQueryWrapperObject = {
		'elementNodeList' : elementNodeList,
		'elementNode' : elementNode,
		
		'css' : function(colorArg) {
			for(var i = 0; i < elementNodeList.length; i++) {
				this.elementNodeList.item(i).style.color = colorArg;
			}
		},
		
		'text' : function(textArg) {
			if(textArg) {
				for(var i = 0; i < this.elementNodeList.length; i++) {
					this.elementNodeList.item(i).firstChild.nodeValue = textArg;
				}
			} else {
				return this.elementNode.firstChild.nodeValue;
			}
		}
		
	};
	
	return jQueryWrapperObject; 
};

window.$ = window.jQuery;