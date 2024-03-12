package com.mydatabase.questRule.controller;
import com.mydatabase.questRule.service.QRService;
import com.mydatabase.questRule.model.QuestRule;
import org.springframework.web.bind.annotation.*;
import java.util.List;
public class QRController {
    private final QRService qrService;

    public QRController(QRService qrService) {
        this.qrService = qrService;
    }
    public void createQR(@RequestBody QuestRule questRule) {
        qrService.createQR(questRule);
    }
    public void deleteQRById(@PathVariable String id) {
        qrService.deleteQRById(id);
    }
    public QuestRule getQRById(@PathVariable String id) {
        return qrService.getQRById(id);
    }
    public void updateQRStatus(@PathVariable String id, @RequestParam int status) {
        qrService.updateQRStatus(id, status);
    }
    public List<QuestRule> getAllQR() {
        return qrService.getAllQR();
    }
}
