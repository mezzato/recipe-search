

var cp = document.location.pathname.substr(0, document.location.pathname.indexOf("/", 1));

var logo_font = {
    src: cp+'/templates/clarity/sifr/big_noodle_titling.swf'
};

sIFR.activate(logo_font);

sIFR.replace(logo_font, {
    selector: '#logo',
    css: ['.sIFR-root {font-size: 70px;}',
    'a { text-decoration: none; color: #cf2838; }',
    'a:hover { text-decoration: none; color: #cf2838; }'
    ],
    wmode: 'transparent',
    transparent: true,
    selectable: true
});
