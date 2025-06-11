package ntub.imd.ntuexam_113;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018BA\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0018\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\u000eH\u0016J\u001c\u0010\u000f\u001a\u00020\b2\n\u0010\u0010\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u001c\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0014\u0010\u0016\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lntub/imd/ntuexam_113/StoreAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lntub/imd/ntuexam_113/StoreAdapter$StoreViewHolder;", "stores", "", "Lntub/imd/ntuexam_113/Store;", "onItemClick", "Lkotlin/Function1;", "", "onRatingChanged", "Lkotlin/Function2;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "updateData", "newStores", "StoreViewHolder", "app_debug"})
public final class StoreAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<ntub.imd.ntuexam_113.StoreAdapter.StoreViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<ntub.imd.ntuexam_113.Store> stores;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<ntub.imd.ntuexam_113.Store, kotlin.Unit> onItemClick = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<ntub.imd.ntuexam_113.Store, java.lang.Float, kotlin.Unit> onRatingChanged = null;
    
    public StoreAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<ntub.imd.ntuexam_113.Store> stores, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super ntub.imd.ntuexam_113.Store, kotlin.Unit> onItemClick, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super ntub.imd.ntuexam_113.Store, ? super java.lang.Float, kotlin.Unit> onRatingChanged) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public ntub.imd.ntuexam_113.StoreAdapter.StoreViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    ntub.imd.ntuexam_113.StoreAdapter.StoreViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    public final void updateData(@org.jetbrains.annotations.NotNull()
    java.util.List<ntub.imd.ntuexam_113.Store> newStores) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lntub/imd/ntuexam_113/StoreAdapter$StoreViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lntub/imd/ntuexam_113/StoreAdapter;Landroid/view/View;)V", "imgStore", "Landroid/widget/ImageView;", "getImgStore", "()Landroid/widget/ImageView;", "ratingBar", "Landroid/widget/RatingBar;", "getRatingBar", "()Landroid/widget/RatingBar;", "txtAddress", "Landroid/widget/TextView;", "getTxtAddress", "()Landroid/widget/TextView;", "txtName", "getTxtName", "txtPhone", "getTxtPhone", "app_debug"})
    public final class StoreViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imgStore = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtName = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtPhone = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.TextView txtAddress = null;
        @org.jetbrains.annotations.NotNull()
        private final android.widget.RatingBar ratingBar = null;
        
        public StoreViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImgStore() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtPhone() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.TextView getTxtAddress() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.RatingBar getRatingBar() {
            return null;
        }
    }
}