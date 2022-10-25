package middle.school.question.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import middle.school.common.utils.Response;
import middle.school.question.entity.Question;
import middle.school.sys.entity.dto.GetListDTO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author
 * @since 2022-03-06
 */
public interface QuestionService extends IService<Question> {

    /**
     * 保存提问
     *
     * @param question
     * @return
     */
    Response saveAsk(Question question);


    Response saveQuestion(Question question, HttpServletRequest request);

    /**
     * 保存反馈
     * @param question
     * @return
     */
    Response saveAnswer(Question question);

    /**
     * 查询问题
     * @param getListDTO
     * @return
     */
    IPage<Question> getQuestion(GetListDTO getListDTO, HttpServletRequest request);
    IPage<Question> getQuestionPar(GetListDTO getListDTO, HttpServletRequest request);
    IPage<Question> getQuestionTea(GetListDTO getListDTO, HttpServletRequest request);
}
