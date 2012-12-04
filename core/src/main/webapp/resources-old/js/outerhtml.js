    /* jquery extentions (help methods) */
    jQuery.fn.extend({ /* jquery object to html-string */
        outerHtml: function(replacement) {
            // We just want to replace the entire node and contents with
            // some new html value
            if (replacement) {
                return this.each(function() {
                    $(this).replaceWith(replacement);
                });
            }

        /*
         * Now, clone the node, we want a duplicate so we don't remove
         * the contents from the DOM. Then append the cloned node to
         * an anonymous div.
         * Once you have the anonymous div, you can get the innerHtml,
         * which includes the original tag.
         */
            var tmp_node = $("<div></div>").append($(this).clone());
            var markup = tmp_node.html();

            // Don't forget to clean up or we will leak memory.
            tmp_node.remove();
            return markup;
        }
    });