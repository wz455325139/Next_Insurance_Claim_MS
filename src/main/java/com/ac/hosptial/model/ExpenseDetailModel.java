package com.ac.hosptial.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class ExpenseDetailModel {

    @JsonProperty("Uid")
    private String uid;

    /**
     * yyyyMMddHHmmss
     */
    @JsonProperty("ExpenseTime")
    private String expenseTime;

    @JsonProperty("Expense")
    private long expense;

    @JsonProperty("Claimed")
    private boolean claimed;

    @JsonProperty("ClaimExpense")
    private long claimExpense;

    @JsonProperty("Medicines")
    private List<MedicineDetailModel> medicines;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getExpenseTime() {
        return expenseTime;
    }

    public void setExpenseTime(String expenseTime) {
        this.expenseTime = expenseTime;
    }

    public long getExpense() {
        return expense;
    }

    public void setExpense(long expense) {
        this.expense = expense;
    }

    public boolean isClaimed() {
        return claimed;
    }

    public void setClaimed(boolean claimed) {
        this.claimed = claimed;
    }

    public long getClaimExpense() {
        return claimExpense;
    }

    public void setClaimExpense(long claimExpense) {
        this.claimExpense = claimExpense;
    }

    public List<MedicineDetailModel> getMedicines() {
        return medicines;
    }

    public void setMedicines(List<MedicineDetailModel> medicines) {
        this.medicines = medicines;
    }
    
    
    


}
