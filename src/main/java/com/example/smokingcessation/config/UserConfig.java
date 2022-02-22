package com.example.smokingcessation.config;

import com.example.smokingcessation.model.Comment;
import com.example.smokingcessation.model.Post;
import com.example.smokingcessation.model.User;
import com.example.smokingcessation.repo.CommentRepository;
import com.example.smokingcessation.repo.PostRepository;
import com.example.smokingcessation.repo.UserRepository;
import com.example.smokingcessation.security.MD5Utils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner commandLineRunnerUser(UserRepository userRepository, PostRepository postRepository, CommentRepository commentRepository){
        return args -> {
            ArrayList<User> users = new ArrayList<>();

            users.add(
                    new User("jeman",
                            MD5Utils.hash("password"),
                            12,
                            5,
                            "Marawi",
                            getByteArray("startPics/jeman.png"))
            );
            users.add(
                    new User("albrent",
                            MD5Utils.hash("password"),
                            12,
                            8,
                            "Iligan",
                            getByteArray("startPics/albrent.png")));
            users.add(new User(
                    "genrev",
                    MD5Utils.hash("password"),
                    "Ozamiz",
                    LocalDate.of(1999,9,9),
                    LocalDateTime.of(2021,10,12,0,0,0),
                    0.1,
                    LocalDateTime.of(2021,10,19,0,0,0),
                    7,
                    0,
                    0,
                    getByteArray("startPics/genrev.png")
            ));
            userRepository.saveAll(users);
            generatePost(postRepository,
                    commentRepository,
                    users,
                    "Former smokers",
                    "How did you quit?\n" +
                            "\n" +
                            "Hi. I'm pubinthetub and I'm a nicotine addict.\n" +
                            "\n" +
                            "I'm a really heavy smoker. It started in late 2005 so I've been hooked for almost 13 years.\n" +
                            "\n" +
                            "Aside from the health risks (which I'm constantly reminded of by every pack I buy - various types of cancer, emphysema, impotence gasp), sobrang gastos na rin kasi. When I started, a pack of Marlboro Lights was 35 pesos. Now, a pack costs 90+ pesos. 100+ pa sa iba. So you can imagine the expense. It all adds up.\n" +
                            "\n" +
                            "Thing is, I'm physically and psychologically addicted. Addicted ng malala. After waking up, I pee, drink a tall glass of water then smoke my first stick of the (usually long) day. I look forward to every break, every designated smoking area, every chance I can smoke. I also used to smoke while walking noong pwede pa magyosi kahit saan so most likely, I earned the ire of every nonsmoker I encountered.\n" +
                            "\n" +
                            "I've tried quitting countless times. I also fail everytime. The craving gets too intense and I find myself getting antsy with every second. When a craving hits, it doesn't go away. I'm like that with most things e (cigarettes, food, etc).\n" +
                            "\n" +
                            "So... pahingi namang tips o.",
                    "Hey. I know this might be something that you won't expect but maybe you should try to see a psychologist to help with your addiction. I think it'd be nice to get a professional perspective. I'm pretty sure they can help.\n" +
                            "\n" +
                            "Maybe you can also try to lessen your intake a day. If you're doing 6 sticks a day maybe try to do 5x a day then slowly cut the number per week (or whatever time frame suits you).\n" +
                            "\n" +
                            "I agree with the other commenter that you should try to carry candy/gums with you all the time, anything to munch on or anything that can substitute a cigarette stick. And yes, you might also want to get a new hobby/interest or anything that can keep your mind away from smoking.\n" +
                            "\n" +
                            "Take your time. What matters is that you have progress every day/week/month (however little it may be). The fact that you acknowledge that you want to stop smoking is already a thing in itself, so cheers to that.",
                    "Seeing a psychologist crossed my mind but for an entirely different reason. But my dependence on cigarettes may or may not be correlated to the other issue. I'll definitely consider it.\n" +
                            "\n" +
                            "It's hard not to beat myself up for every failure (quitting cigarettes and life in general) but yes, small steps and small victories matter. Thank you!",
                    "Try hitting the gym! It (kinda) worked for me. Hope it works better for you.",
                    "Madali lang naman mag quit bro, ilang beses na nga akong nag qquit eh.",
                    "I started 2001 (1st year high school), stopped cold turkey 2011. Mura pa yosi nung time ko, lahat naka Marlboro golds or black hehe nasa 30 or 40 pesos lang yata. Nag quit ako when I started going to the gym and also realizing the long term negative effects of the vice. The battle is mostly psychologically, it's your mind craving for it.. I try to carry candy/gums with me and pag lunch break, avoid yosi break sessions second hand smoke is worse I heard. Get a hobby, new interests, anything that can keep your mind away from smoking. And sumama ka sa mga tao na hindi nagyoyosi, hahaha yan pinka effective.");
            generatePost(postRepository,
                    commentRepository,
                    users,
                    "Why did u quit Smoking?",
                    "Filipino students arent a stranger tk terms such as \"walwal\" and \"vape on\". As a student did/do you have vices? smoking or drinking alcohol? What caused you to do it? And what made you turn your back at it? Did school, peers, family played a role into making you quit? Or did you made the decision yourself for the better? I need information about a story im making about students overcoming their vices.",
                    "I was in the smoking area one day overlooking the highway. The smog from the jeepneys and buses mixing with the smoke from our cigarettes. On the other side of the street are some homeless families sleeping. I realize that here I am, a third world man living in a third world country contributing to the cliché of a third world habit and i wanted none of it anymore. So i quit.",
                    "Ang hirap kasi umakyat sa lrt pag mahina baga.",
                    "Health paranoia made me stop.\n" +
                            "\n" +
                            "10 years na ako quit this past June.",
                    "I want to quit kasi I found out na smoking is one of the causes of my allergies (nagkakaroon ako ng mga rashes + sumisikip sinus ko) but it is really hard to quit.\uD83D\uDE2D For those who successfully quit, advice please.",
                    "Nung HS ako, I try to have a smoke pag may lakwatsa -- fun lang kasi, feeling rebellious ganyan. Di palagi kasi siyempre ayaw natin matrobol. Had a girlfriend in 4th year and she told me to stop. So I did. Pero nung break na kami, 1st year college na ko nun, full steam ahead na sa pagyoyosi! Mura, accessible, pampatanggal stress, a way to connect with people. Tsaka pag wala nang allowance at gutom ako, dinadaan ko na lang sa yosi, keri na yun.\n" +
                            "\n" +
                            "It took years of post-college before I quit, pero dahil students naman target mo for your study eh di ko na ito pahahabain hehe");

        };
    }

    @Transactional
    public static void generatePost(PostRepository postRepository,
                                    CommentRepository commentRepository,
                                    ArrayList<User> userList,
                                    String postTitle,
                                    String postBody,
                                    String ... comments){
        Post post = new Post(
                postTitle,
                postBody,
                LocalDateTime.now(),
                new HashSet<>(),
                userList.get(new Random().nextInt(userList.size()))
        );
        HashSet<Comment> commentSet = new HashSet<>();
        Random rand = new Random();
        for(String comment: comments){
            commentSet.add(
                    new Comment(
                            userList.get(new Random().nextInt(userList.size())),
                            comment,
                            post,
                            LocalDateTime.of(rand.nextInt(4)+2017,rand.nextInt(12)+1,rand.nextInt(20)+1, rand.nextInt(12),rand.nextInt(58),rand.nextInt(58))
                    )
            );
        }
        HashSet<Comment> commentSetSaved = new HashSet<>(commentRepository.saveAll(commentSet));
        post.setComments(commentSetSaved);
        postRepository.save(post);
    }

    public static byte[] getByteArray(String url){
        ClassPathResource backImgFile = new ClassPathResource(url);
        byte[] arrayPic = null;
        try {
            arrayPic = new byte[(int) backImgFile.contentLength()];
            backImgFile.getInputStream().read(arrayPic);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return arrayPic;
    }
}
