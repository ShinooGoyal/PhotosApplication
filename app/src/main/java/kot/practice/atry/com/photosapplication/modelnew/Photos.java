
package kot.practice.atry.com.photosapplication.modelnew;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Photos {

    @SerializedName("hits")
    private List<Hit> mHits;
    @SerializedName("total")
    private Long mTotal;
    @SerializedName("totalHits")
    private Long mTotalHits;

    public List<Hit> getHits() {
        return mHits;
    }

    public void setHits(List<Hit> hits) {
        mHits = hits;
    }

    public Long getTotal() {
        return mTotal;
    }

    public void setTotal(Long total) {
        mTotal = total;
    }

    public Long getTotalHits() {
        return mTotalHits;
    }

    public void setTotalHits(Long totalHits) {
        mTotalHits = totalHits;
    }

}
