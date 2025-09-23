class MovieRentingSystem {

    static class Movie{
        int shop,movie,price;

        Movie(int shop, int movie, int price){
            this.shop=shop;
            this.movie=movie;
            this.price=price;
        }
    }

    private static final Comparator<Movie> UNRENTED=(a,b)-> a.price!=b.price ? a.price-b.price : a.shop-b.shop;

    private static final Comparator<Movie> RENTED=(a,b)-> a.price!=b.price? a.price-b.price : (a.shop!=b.shop? a.shop-b.shop : a.movie-b.movie);

    private Map<Integer,TreeSet<Movie>> unrented;
    private TreeSet<Movie> rented;
    private Map<List<Integer>, Movie> lookup;

    public MovieRentingSystem(int n, int[][] entries) {

        unrented= new HashMap<>();
        rented= new TreeSet<>(RENTED);
        lookup= new HashMap<>();


        for(int e[] : entries){
            int shop= e[0], movie=e[1], price=e[2];

            Movie m= new Movie(shop,movie,price);

            unrented.computeIfAbsent(movie,k->new TreeSet<>(UNRENTED)).add(m);
            lookup.put(Arrays.asList(shop,movie),m);
        }
        
    }
    
    public List<Integer> search(int movie) {

        List<Integer> ans= new ArrayList<>();
        if(!unrented.containsKey(movie)) return ans;

        //we need to return top 5 copies
        TreeSet<Movie> set= unrented.get(movie);
        int count=0;

        for(Movie m: set){
            ans.add(m.shop);
            if(++count==5) break;
        }

        return ans;    
    }
    
    public void rent(int shop, int movie) {

        Movie m= lookup.get(Arrays.asList(shop,movie));
        unrented.get(movie).remove(m);

        rented.add(m);

        
    }
    
    public void drop(int shop, int movie) {
        
        Movie m= lookup.get(Arrays.asList(shop,movie));
        unrented.get(movie).add(m);

        rented.remove(m);
    }
    
    public List<List<Integer>> report() {

        List<List<Integer>> ans= new ArrayList<>();
        int count=0;

        for(Movie m: rented){
            ans.add(Arrays.asList(m.shop,m.movie));
            if(++count==5) break;
        }
        

        return ans;
    }
}

/**
 * Your MovieRentingSystem object will be instantiated and called as such:
 * MovieRentingSystem obj = new MovieRentingSystem(n, entries);
 * List<Integer> param_1 = obj.search(movie);
 * obj.rent(shop,movie);
 * obj.drop(shop,movie);
 * List<List<Integer>> param_4 = obj.report();
 */