function selectTab(tabSelect) {
    ['result', 'tree', 'zipper'].forEach(function(tabType) {
        document.querySelectorAll('.tab.' + tabType).forEach(function (button) {
            if (tabType == tabSelect) {
                button.classList.add('selected');
            } else {
                button.classList.remove('selected');
            }
        });

        document.querySelectorAll('.tab-content.' + tabType).forEach(function (content) {
            if (tabType == tabSelect) {
                content.classList.remove('dn');
            } else {
                content.classList.add('dn');
            }
        });
    });
}
