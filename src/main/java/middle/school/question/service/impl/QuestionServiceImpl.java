package middle.school.question.service.impl;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import middle.school.common.utils.JwtUtil;
import middle.school.common.utils.Response;
import middle.school.question.entity.Question;
import middle.school.question.mapper.QuestionMapper;
import middle.school.question.service.QuestionService;
import middle.school.sys.entity.dto.GetListDTO;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author
 * @since 2022-03-06
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Override
    public Response saveAsk(Question question) {
        this.save(question);
        return Response.success();

    }

    @Override
    public Response saveQuestion(Question question, HttpServletRequest request) {
        String token = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(token);
        Integer userid = (Integer)hashMap.get("uid");
        question.setParentId(userid);
        this.save(question);
        return Response.success();

    }

    @Override
    public Response saveAnswer(Question question) {
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Question::getId,question.getId());
        Question one = this.getOne(queryWrapper);
        one.setStatus(true);
        one.setQuestionAnswer(question.getQuestionAnswer());
        this.updateById(one);
        return Response.success();
    }

    @Override
    public IPage<Question> getQuestion(GetListDTO getListDTO, HttpServletRequest request) {
        Page<Question> page = new Page<>(getListDTO.getPage(), getListDTO.getPer_page());
        String token = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(token);
        Object uid = hashMap.get("uid");
        Object role = hashMap.get("role");
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(role.equals("parent"),Question::getParentId,uid)
                .eq(role.equals("teacher"),Question::getTeacherId,uid);
        return this.getBaseMapper().selectPage(page, queryWrapper);

    }

    @Override
    public IPage<Question> getQuestionPar(GetListDTO getListDTO, HttpServletRequest request) {
        Page<Question> page = new Page<>(getListDTO.getPage(), getListDTO.getPer_page());
        String token = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(token);
        Object uid = hashMap.get("uid");
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Question::getParentId,uid);
        return this.getBaseMapper().selectPage(page, queryWrapper);

    }

    @Override
    public IPage<Question> getQuestionTea(GetListDTO getListDTO, HttpServletRequest request) {
        Page<Question> page = new Page<>(getListDTO.getPage(), getListDTO.getPer_page());
        String token = request.getHeader("X-Token");
        HashMap<String, Object> hashMap = JwtUtil.parseToken(token);
        Object uid = hashMap.get("uid");
        QueryWrapper<Question> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Question::getTeacherId,uid);
        return this.getBaseMapper().selectPage(page, queryWrapper);

    }
}
