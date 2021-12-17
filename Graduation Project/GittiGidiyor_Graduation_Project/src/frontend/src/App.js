import './App.css';
import {applyCredit, inquiryCredit} from "./client";
import {Button, Divider, Form, Input} from 'antd';
import {errorNotification, successNotification} from "./Notification";

const validateMessages = {
    required: '${label} is required!',
    types: {
        email: '${label} is not a valid email!',
        number: '${label} is not a valid number!',
    },
    number: {
        range: '${label} must be between ${min} and ${max}',
    },
};

const App = () => {

    const onFinish = user => {
        applyCredit(user)
            .then(() => {
                successNotification(
                    "You successfully applied credit",
                    `${user.name} was added to the system`
                )
            })
    };

    const onFinishQuery = id => {
        console.log(id);
        inquiryCredit(id)
            .then(res => {
                console.log(res);
                successNotification(
                    "Inquiry attempt successful",
                )
            })
    };

    return (
        <div className="App">
            <header className="App-header">
                <h1>CREDIT APPLICATION</h1>
                <Form onFinish={onFinish} validateMessages={validateMessages}>
                    <Form.Item className="frame"
                               name='fullName'
                               label="Name"
                               rules={[
                                   {
                                       required: true,
                                   },
                               ]}
                    >
                        <Input className="text-field"/>
                    </Form.Item>
                    <Form.Item className="frame" name='identityNumber' label="T.C. Identity Number">
                        <Input className="text-field"/>
                    </Form.Item>
                    <Form.Item className="frame" name='monthlyIncome' label="Monthly Income">
                        <Input className="text-field"/>
                    </Form.Item>
                    <Form.Item className="frame" name='phoneNumber' label="Phone Number">
                        <Input className="text-field"/>
                    </Form.Item>
                    <Form.Item className="frame">
                        <Button className="button" type="primary" htmlType="submit">
                            Apply
                        </Button>
                    </Form.Item>
                </Form>

                <Divider/>

                <h1>CREDIT RESULT INQUIRY</h1>
                <Form onFinish={onFinishQuery} validateMessages={validateMessages}>
                    <Form.Item className="frame"
                               name='identityNumber'
                               label="T.C. Identity Number"
                               rules={[
                                   {
                                       required: true,
                                   },
                               ]}
                    >
                        <Input className="text-field"/>
                    </Form.Item>

                    <Form.Item className="frame">
                        <Button className="button" type="primary" htmlType="submit">
                            Apply
                        </Button>
                    </Form.Item>
                </Form>
            </header>
        </div>
    );
};

export default App;
