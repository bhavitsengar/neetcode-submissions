/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {


    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        
        List<String> results = new ArrayList<>();

        int i = startUrl.indexOf("/");

        StringBuilder builder = new StringBuilder();

        int curr = i+2;
        
        while(curr < startUrl.length() && startUrl.charAt(curr) != '/') {

            char c = startUrl.charAt(curr);
            builder.append(c);
            curr++;
        }

        System.out.println(builder);

        Set<String> visited = new HashSet<>();

        crawl(builder.toString(), startUrl, htmlParser, results, visited);

        return results;
    }

    private void crawl(String startDomain, String url, HtmlParser htmlParser, 
                                    List<String> results, Set<String> visited) {

        if(url.contains(startDomain)) {
            results.add(url);

            visited.add(url);
        
            List<String> subUrls = htmlParser.getUrls(url);
            
            for(String subUrl : subUrls) {
                if(!visited.contains(subUrl)) {
                    crawl(startDomain, subUrl, htmlParser, results, visited);
                }
            }
        }
    }
}
