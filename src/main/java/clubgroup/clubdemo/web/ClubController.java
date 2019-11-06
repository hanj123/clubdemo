package clubgroup.clubdemo.web;


import clubgroup.clubdemo.clubException;
import clubgroup.clubdemo.po.club;
import clubgroup.clubdemo.service.clubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class ClubController {

    @Autowired
    private clubService clubService;

    /**
     * 首页展示所有的俱乐部列表信息
     *
     * @param model
     * @return
     */
    @GetMapping("/")
    public String index(Model model) {
        List<club> clubList = clubService.listClub();
        model.addAttribute("clubList", clubList);
        return "club_list";
    }

    /**
     * 跳转到新增页面
     *
     * @return
     */
    @RequestMapping("/goAddPage")
    public String goAddPage() {
        return "club_add";
    }

    /**
     * 新增操作，新增完成后跳转到列表页
     *
     * @param club
     * @return
     */
    @RequestMapping("/add")
    public String add(club club, RedirectAttributes attr) {
        clubService.saveClub(club);
        String clubName = club.getClubName();
        attr.addFlashAttribute("message", "新增俱乐部：" + clubName);
        return "redirect:/";
    }

    /**
     * 跳转到更新页面
     *
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/goUpdatePage/{id}")
    public String goUpdatePage(@PathVariable Long id, Model model) {
        club theClub = clubService.findClubById(id);
        model.addAttribute("club", theClub);
        return "club_update";
    }

    /**
     * 更新俱乐部
     *
     * @param club
     * @param id
     * @return
     */
    @RequestMapping("/update/{id}")
    public String update(club club, @PathVariable Long id, RedirectAttributes attr) {
        clubService.updateClub(club, id);
        String clubName = club.getClubName();
        attr.addFlashAttribute("message", "修改" + clubName + "俱乐部的信息成功！");
        return "redirect:/";
    }

    @RequestMapping("/delete/{id}")
    public String deleteClub(@PathVariable Long id, RedirectAttributes attr) {
        club delClub = clubService.findClubById(id);
        Long memberNumber = delClub.getMemberNumber();
        String clubName = delClub.getClubName();
        if (memberNumber > 0) {
            attr.addFlashAttribute("message", "删除俱乐部失败！因为" + clubName + "的会员数不为0。");
            return "redirect:/";
        }
        if (memberNumber < 0) {
            throw new clubException("此处异常原因：会员数小于0");
        }
        clubService.deleteClub(id);
        attr.addFlashAttribute("message", "删除俱乐部：" + clubName + "成功！");
        return "redirect:/";
    }

    /**
     * ajax请求判断俱乐部名称是否重复，重复返回字符串"false"，不重复返回"true"
     *
     * @param nameMap
     * @return
     */
    @RequestMapping("/checkNameOfAdd")
    public @ResponseBody String checkNameOfAdd(@RequestBody Map<String, String> nameMap) {
        String inputName = nameMap.get("clubName");
        List<club> clubList = clubService.listClub();
        List<String> nameList = new ArrayList<>();
        for (club cb : clubList) {
            String clubName = cb.getClubName();
            nameList.add(clubName);
        }
        if (nameList.contains(inputName)) {
            return "false";
        } else {
            return "true";
        }
    }

    @RequestMapping("/checkNameOfUpdate")
    public @ResponseBody String checkNameOfUpdate(@RequestBody Map<String, String> nameMap) {
        String inputName = nameMap.get("clubName");
        String clubId = nameMap.get("clubId");
        Long id = Long.parseLong(clubId);
        List<club> clubList = clubService.listOtherClub(id);
        List<String> nameList = new ArrayList<>();
        for (club cb : clubList) {
            String clubName = cb.getClubName();
            nameList.add(clubName);
        }
        if (nameList.contains(inputName)) {
            return "false";
        } else {
            return "true";
        }
    }
}