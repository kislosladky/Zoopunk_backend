package zoopunk.backend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zoopunk.backend.Entity.Achievement;
import zoopunk.backend.Entity.AchievementProgress;
import zoopunk.backend.Entity.Quiz;
import zoopunk.backend.Entity.QuizProgress;
import zoopunk.backend.Repository.AchievementProgressRepository;
import zoopunk.backend.Repository.AchievementRepository;
import zoopunk.backend.Repository.QuizProgressRepository;
import zoopunk.backend.Repository.QuizRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class QuizProgressService {
    @Autowired
    QuizProgressRepository quizProgressRepository;

    @Autowired
    AchievementRepository achievementRepository;

    @Autowired
    AchievementProgressRepository achievementProgressRepository;

    @Autowired
    QuizRepository quizRepository;

    public void saveProgressAndGetAchievement(QuizProgress quizProgress) {
        quizProgressRepository.save(quizProgress);

        Optional<Quiz> quiz = quizRepository.findById(quizProgress.getQuizid());

        if (quiz.isEmpty()) {
            return;
        }

        UUID achievementId = quiz.get().getAchievementsId();
        if (achievementId == null) {
            return;
        }

        Optional<Achievement> optionalAchievement =
                achievementRepository.findById(achievementId);
        if (optionalAchievement.isEmpty()) {
            return;
        }
        Achievement achievement = optionalAchievement.get();

        if (quizProgress.getQuizResult() >= achievement.getPointsfordone()) {
            AchievementProgress progress =
                    new AchievementProgress(quizProgress.getUserid(), achievementId);
            achievementProgressRepository.save(progress);
        }
    }
}
