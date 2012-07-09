function Parancoe() {
    function Util() {
        this.initDWR = function () {
            dwr.engine.setPreHook(function() {
                var loadingMessage = "Loading...";
                var messageZone = $('messageZone');
                if (!messageZone) {
                  messageZone = document.createElement('div');
                  messageZone.setAttribute('id', 'messageZone');

                  document.body.appendChild(messageZone);
                  var text = document.createTextNode(loadingMessage);
                  messageZone.appendChild(text);
                }
                else {
                  messageZone.innerHTML = loadingMessage;
                  messageZone.style.visibility = 'visible';
                }
            });

            dwr.engine.setPostHook(function() {
                $('messageZone').style.visibility = 'hidden';
            });

            dwr.engine.reverseAjax = true;
        };

        this.disableFormElement = function (elementId) {
            $(elementId).disabled = true;
        }

        this.enableFormElement = function (elementId) {
            $(elementId).disabled = false;
        }
    }

    this.util = new Util();
}

var parancoe = new Parancoe();

